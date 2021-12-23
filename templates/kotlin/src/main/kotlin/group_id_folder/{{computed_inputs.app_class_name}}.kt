package {{project_group_id}}

import software.amazon.awscdk.core.App
import software.amazon.awscdk.core.Environment
import software.amazon.awscdk.core.StackProps

const val APP_NAME = "{{inputs.project_name|lower|replace(' ', '-')}}"
const val APP_PORT = 8080

fun main() {
    val app = App()

    val environment = Environment.builder()
        .account(System.getenv("AWS_ACCOUNT_NUMBER"))
        .region(System.getenv("AWS_REGION"))
        .build()

    {{computed_inputs.app_class_name}}Stack(app, "$APP_NAME-stack", StackProps.builder().env(environment).build())

    app.synth()
}