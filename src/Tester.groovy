
#!/usr/bin/env groovy
def BRANCH = 'master'

//groovy script does checkout

job('Testing_job') {

    description('Practice')

    label('master')

    //keep history of30 builds - every time run job - get job number -
    //start rotating the jobs - delete
    logRotator {
        numToKeep(30)
    }

    wrappers { //add timestamp to log
        timestamps()
    }

    //variable - used somewhere else - passed into the scripts
    parameters {

        stringParam('VAR', '', 'Insert Variable ')
    }

    job()
            { scm{
                git{
                    remote{
                        github(${jpha}/${test})
                    }
                }
            }
            }
    //scm
    check checkout

//use bash script to do a backup
