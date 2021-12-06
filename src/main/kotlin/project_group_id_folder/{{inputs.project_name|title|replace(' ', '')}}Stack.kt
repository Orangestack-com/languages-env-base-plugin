package {{inputs.project_group_id}}

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps

class {{inputs.project_name|title|replace(" ", "")}}Stack(scope: Construct?, id: String?, props: StackProps?) : Stack(scope, id, props) {
    init {
        // Code here
    }
}