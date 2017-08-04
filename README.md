# Java Deployment pipeline

This is a very MVP version of java api `/hello/{name}` and `/health` obviously it's springboot app.

However with aws `buildspec.yml` and `appspec.yml` and cloudformation file

quite the same as Go version [here](https://github.com/awslabs/golang-deployment-pipeline) with some infra, code, script update to use with java. 

## Notes
Amazon ami comes with openjdk7, while code aims for openjdk8 so you can see infrastructure code to remove and reinstall 8. Only install openjdk8 won't work!

SpringBoot app using as example, use embeded tomcat as servlet engine so it needs a bit of time to start up, that reflects on `codedeploy/ValidateService.sh`