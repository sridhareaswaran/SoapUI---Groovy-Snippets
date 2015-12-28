import com.eviware.soapui.impl.wsdl.teststeps.*
import com.eviware.soapui.support.types.StringToStringsMap;

def project = testRunner.testCase.testSuite.project;

project.getTestSuiteList().each{
    tsuite->
        tsuite.getTestCaseList().each {
            tcase->
                tcase.getTestStepList().each {
                    tstep->
                            if( tstep instanceof WsdlTestRequestStep || tstep instanceof RestTestRequestStep) {
                                 def new_headers = new StringToStringMap()
                                 def headers = it.getHttpRequest().getRequestHeaders()
                                 headers.each
                                 {
                                  	h_name,h_value ->
                                  	new_headers.put(h_name,h_value)
                                 }
                                 //here goes your new header(s)
                                 new_headers.put("header_name1","value");
                                 new_headers.put("header_name2","value");
                                 it.getHttpRequest().setRequestHeaders(new_headers)
                            }
                }
        }
}
