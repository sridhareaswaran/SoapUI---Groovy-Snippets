/* Get Assertion & their status at test case level.groovy */

import com.eviware.soapui.impl.wsdl.teststeps.assertions.ResponseAssertion

def tcase = testRunner.testCase;
log.info("Assertion Status for : ${tcase.getLabel()}")
tcase.getTestStepList().each
{
  it->
  		if(it.config.type.equals("restrequest"))
  		{
	          log.info("==> " + it.getLabel())
	          assertions = it.getAssertionList().size() - 1
	          for(num in 0..assertions)
	          {
	             log.info("${it.getAssertionAt(num).getStatus()}  on asserting for - ${it.getAssertionAt(num).getName()}")
	             error = it.getAssertionAt(num).getErrors()
	             if (error != null)
	             {
	                 log.info(error[0].getMessage())
	             }
	          }
  		}
}
