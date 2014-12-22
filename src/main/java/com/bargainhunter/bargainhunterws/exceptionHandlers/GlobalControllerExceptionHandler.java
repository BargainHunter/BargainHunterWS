package com.bargainhunter.bargainhunterws.exceptionHandlers;

import com.bargainhunter.bargainhunterws.exceptions.*;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Company")
    @ExceptionHandler(CompanyNotFoundException.class)
    public void handleCompanyNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Branch")
    @ExceptionHandler(BranchNotFoundException.class)
    public void handleBranchNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Store")
    @ExceptionHandler(StoreNotFoundException.class)
    public void handleStoreNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Offer")
    @ExceptionHandler(OfferNotFoundException.class)
    public void handleOfferNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Category")
    @ExceptionHandler(CategoryNotFoundException.class)
    public void handleCategoryNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Subcategory")
    @ExceptionHandler(SubcategoryNotFoundException.class)
    public void handleSubcategoryNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    @ExceptionHandler(Exception.class)
    public void defaultErrorHandler(Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;
    }
}
