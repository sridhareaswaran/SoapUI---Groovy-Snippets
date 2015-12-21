import com.eviware.soapui.model.testsuite.Assertable

def tcase = testRunner.testCase
log.info("Assertion Status for : ${tcase.getLabel()}")
tcase.getTestStepList().each 
{
  tstep->
          log.info("==> " + tstep.getLabel())
          tstep.getAssertionList().each
          {
            assert->
                  log.info(assert.getStatus() + " on asserting for - " + assert.getName())
                  error = assert.getErrors()
                  if (error != null)
                  {
                      log.info(error[0].getMessage())
                  }
          }
            
}

