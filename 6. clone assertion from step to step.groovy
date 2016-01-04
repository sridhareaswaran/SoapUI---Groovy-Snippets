import com.eviware.soapui.impl.wsdl.teststeps.*
import com.eviware.soapui.model.testsuite.Assertable 

def project = testRunner.testCase.testSuite.project;
def srcStep = project.getTestSuiteByName("tsuite name").getTestCaseByName("tcase name").getTestStepByName("tstep name") 
def targetStepName = "TC Name"
def count = srcStep.getAssertionList().size()

project.getTestSuiteList().each{
    tsuite->
        tsuite.getTestCaseList().each {
            tcase->
                tcase.getTestStepList().each {
                    tstep->
                            if( tstep instanceof WsdlTestRequestStep || tstep instanceof RestTestRequestStep) 
                            {
                              //add assertion only to steps with target name 
                              if( tstep.getLabel == targetStepName)
                              {
                                for (i in 0..<count)
                                {
                                  tstep.cloneAssertion(srcStep.getAssertionAt(i), srcStep.getAssertionAt(i).getName())
                                }
                              }
                            }
                }
        }
}

log.info "done ;)"
