/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.context;

import com.nerv.cash.core.exception.BusinessException;
import com.nerv.cash.web.context.messages.BusinessExceptionMessages;
import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import org.apache.deltaspike.core.api.provider.BeanProvider;

/**
 * Handler de exceções não tratadas nos managed beans.
 * @author Vitor
 */
class CustomExceptionHandler extends ExceptionHandlerWrapper {
    
    private final ExceptionHandler wrapped;

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterable<ExceptionQueuedEvent> ex = getUnhandledExceptionQueuedEvents();
        Iterator<ExceptionQueuedEvent> it = ex.iterator();
        while (it.hasNext()) {
            try {
                ExceptionQueuedEventContext context = it.next().getContext();
                Throwable exception = context.getException();
                
                while (exception != null && !(exception instanceof BusinessException)) {
                    exception = exception.getCause();
                }
                
                if (exception != null) {
                    BusinessException cause = (BusinessException) exception;
                    showMessage(cause);
                } else {
                    toErrorPage();
                    break;
                }
            } finally {
                it.remove();
            }
        }
        getWrapped().handle();
    }
    /**
     * Redireciona para a página de erros da aplicação.
     */
    private void toErrorPage() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        NavigationHandler nav = ctx.getApplication().getNavigationHandler();
        nav.handleNavigation(ctx, null, "error?faces-redirect=true");
        ctx.responseComplete();
    }
    /**
     * Insere a mensagem traduzida no contexto para exibição na tela.
     * @param e A exceção de negócio lançada.
     */
    private void showMessage(BusinessException e) {
        FacesMessage message = new FacesMessage(translateMessage(e));
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, message);
    }
    /**
     * Traduz a exceção de negócio lançada pela aplicação numa mensagem 
     * legível ao usuário.
     * @param e A exceção de negócio lançada.
     * @return A mensagem associada a exceção já traduzida.
     */
    private String translateMessage(BusinessException e) {
        BusinessExceptionMessages translator = 
                BeanProvider.getContextualReference(BusinessExceptionMessages.class);
        return translator.translate(e);
    }
}