import com.eviware.soapui.impl.wsdl.teststeps.*
import com.eviware.soapui.support.types.StringToStringMap;

def project = testRunner.testCase.testSuite.project;

project.getTestSuiteList().each{
    tsuite->
        tsuite.getTestCaseList().each {
            tcase->
                tcase.getTestStepList().each {
                    tstep->
                            if( tstep instanceof WsdlTestRequestStep || tstep instanceof RestTestRequestStep) {
                                 def new_headers = new StringToStringMap()
                                 def headers = tstep.getHttpRequest().getRequestHeaders()
                                 headers.each
                                 {
                                 	def h_name = it.key
                                 	def h_value = it.value[0]
                                  	new_headers.put(h_name,h_value)
                                 }
                                 //here goes your new header(s)
                                 new_headers.put("header_name1","value");
                                 new_headers.put("header_name2","value");
                                 tstep.getHttpRequest().setRequestHeaders(new_headers)
                            }
                }
        }
}

log.info "done ;)"
