   /* Setting up HTTP Basic Authentication for A Test Request  */

    import com.eviware.soapui.impl.wsdl.teststeps.*

    for( testCase in testSuite.getTestCaseList() )
    {
    
      log.info("Setting basic auth for all WSDL test requests in test case ["+testCase.getLabel()+"]")
      for( testStep in testCase.getTestStepList() ) 
      {

        if( testStep instanceof WsdlTestRequestStep ) 
        {
          testStep.getTestRequest().setUsername("user")
          testStep.getTestRequest().setPassword("pwd")
        }

      }

    }
