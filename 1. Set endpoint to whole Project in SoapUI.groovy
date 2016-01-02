/* Set endpoint to whole Project in SoapUI */

def endpoint = '${#Project#EndPoint}'
testRunner.testCase.testSuite.project.testSuites.each
        {
            suit ->
                suit.getValue().testCases.each
                        {
                            q1->
                                q1.getValue().testSteps.each
                                        {
                                            it->
                                                if (it.getValue().config.type.equals("restrequest"))
                                                {
                                                    it.getValue().getHttpRequest().setEndpoint(endpoint);
                                                }
                                        }
                        }
        }
log.info("Done !!")
