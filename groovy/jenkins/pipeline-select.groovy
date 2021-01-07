#!/usr/bin/env groovy

def values

pipeline {
    agent any
    stages {
        stage("choose value") {
            steps {
                script {
                    echo 'Step 1'
                    MYLIST = []
                    MYLIST += "ch-one\n"
                    MYLIST += "ch-two\n"
                    MYLIST += "ch-three\n"
                    MYLIST += "ch-four\n"
                    MYLIST += "ch-five\n"
                    
                    timeout(time: 5, unit: "MINUTES") {
                        input message: 'Do you want to approve the deploy in production?', ok: 'Yes'
                    }
                    // values = input message: 'Choose values!', ok: 'SET', parameters: [choice(name: 'Choices ', choices: MYLIST, description: '')]
                    // echo values
                }            
            }
        }    
    }
}
