package {{inputs.project_group_id}}

import software.amazon.awscdk.core.App
import software.amazon.awscdk.core.Environment
import software.amazon.awscdk.core.StackProps

const val APP_NAME = "{{inputs.project_name|lowercase|replace(' ', '')}}"
const val APP_PORT = 8080

fun main() {
    val app = App()

    val environment = Environment.builder()
        .account(System.getenv("AWS_ACCOUNT_NUMBER"))
        .region(System.getenv("AWS_REGION"))
        .build()

    {{inputs.project_name|title|replace(" ", "")}}Stack(app, "$APP_NAME-stack", StackProps.builder().env(environment).build())

    app.synth()
}