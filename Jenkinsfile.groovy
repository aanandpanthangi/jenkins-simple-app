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
                echo "Building project..."
                bat 'echo Build step executed successfully!'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests (placeholder, since this is static HTML)"
                bat 'echo Test step executed successfully!'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo "Deploying to staging directory..."
                bat '''
                    if not exist C:\\staging mkdir C:\\staging
                    xcopy * C:\\staging /E /I /Y
                '''
                echo "App deployed to C:\\staging successfully!"
            }
        }
    }
}
