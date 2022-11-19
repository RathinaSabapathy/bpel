package com.custom.java.encodedecode;

import java.util.List;

import oracle.fabric.common.xml.xpath.IXPathContext;
import oracle.fabric.common.xml.xpath.IXPathFunction;

import oracle.fabric.common.xml.xpath.XPathFunctionException;

import oracle.soa.common.util.Base64Decoder;
import oracle.soa.common.util.Base64Encoder;


public class CustomEncodeDecodeXpathUtil {
    
    
    public static class CustomBase64EncodeDecodeFunction implements IXPathFunction {
       
        public Object call(IXPathContext xpathCtx, List list) throws XPathFunctionException{
            String response=null;
            String action= null;
            String content = null;
            try{
                
            
            if (list !=null && !list.isEmpty()){
                System.out.println("--inside EncodeDecode custom function--");
                if (list.get(0) instanceof String){
                    action = (String)list.get(0);
                }
                if (list.get(1) instanceof String){
                    content=(String)list.get(1);
                }
                
                if("Encode".equals(action)){
                    response = base64Encode(content);
                }
                if("Decode".equals(action)){
                    response = base64Decode(content);
                }
            }
            }catch(Exception ex){
                throw new XPathFunctionException(ex.getMessage(), ex);
            }
        return response;
        }
    
    
    public static String base64Encode(String content) throws Exception{
        Base64Encoder encoder = new Base64Encoder();
        return encoder.encode(content);
    }
    
    public static String base64Decode(String content) throws Exception{
        Base64Decoder decoder= new Base64Decoder();
        return decoder.decode(content);
    }

    }
}
