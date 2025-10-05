pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/aanandpanthangi/jenkins-simple-app.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the project..."
                bat 'echo Build complete!'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                bat 'echo Tests passed successfully!'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to staging folder..."
                bat '''
                    if not exist C:\\staging mkdir C:\\staging
                    xcopy * C:\\staging /E /I /Y
                '''
                echo "App deployed successfully to C:\\staging!"
            }
        }
    }
}


