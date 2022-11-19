package com.sample.faulthandling;

import com.collaxa.cube.engine.fp.BPELFaultRecoveryContextImpl;

import com.oracle.bpel.client.BPELFault;

import oracle.integration.platform.faultpolicy.IFaultRecoveryContext;
import oracle.integration.platform.faultpolicy.IFaultRecoveryJavaClass;

public class GenericFaultHandlerUtility implements IFaultRecoveryJavaClass {
    public GenericFaultHandlerUtility() {
        super();
    }

    @Override
    public void handleRetrySuccess(IFaultRecoveryContext iFaultRecoveryContext) {
        // TODO Implement this method
    }

    @Override
    public String handleFault(IFaultRecoveryContext iFaultRecoveryContext) {
        System.out.println("Inside HandleFault");
        
        BPELFaultRecoveryContextImpl bpelFaultCtx=(BPELFaultRecoveryContextImpl)iFaultRecoveryContext;
        BPELFault fault=bpelFaultCtx.getFault();
        System.out.println("fault.getMessage"+fault.getMessage());
        System.out.println("fault.getFaultName"+fault.getFaultName());
        System.out.println("fault.getMessage"+fault.getProperties().entrySet().iterator());
        return "OK";
    }
}
