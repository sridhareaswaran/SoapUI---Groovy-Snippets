/* add/edit headers & mediatype of HTTP requests in SoapUI  */

import com.eviware.soapui.impl.wsdl.teststeps.*
import com.eviware.soapui.support.types.StringToStringsMap;

def project = testRunner.testCase.testSuite.project;
com.eviware.soapui.SoapUI.logMonitor.getLogArea("script log").clear()

project.getTestSuiteList().each{
    tsuite->
        tsuite.getTestCaseList().each {
            tcase->
                tcase.getTestStepList().each {
                    tstep->
                            if( tstep instanceof WsdlTestRequestStep || tstep instanceof RestTestRequestStep) {
                                def headers = new StringToStringsMap()
                                headers.put("header-name1","value1")
                                headers.put("header-name2","value2")
                                log.info("Setting :headers: ${headers} :testCase: ${tcase.getLabel()} :testStep: ${tstep.getLabel()}")
                                //add header
                                tstep.getTestRequest().setRequestHeaders(headers)
                                //add media-type
                                tstep.getTestRequest().setMediaType('application/json')
                            }
                }
        }
}