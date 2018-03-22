package cs545.airline.delete;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class DeleteFlow implements Serializable {
    private static final long serialVersionUID = 1L;

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder builder) {
        builder.id("", "delete");
        builder.viewNode("confirm", "/delete/confirmDelete.xhtml").markAsStartNode();

        builder.methodCallNode("execute")
                .expression("#{airlineBean.deleteAirline(airline.id)}")
                .defaultOutcome("check-result");
        builder.switchNode("check-result")
                .switchCase()
                .condition("success")
                .fromOutcome("success")
                .switchCase()
                .condition("failure")
                .fromOutcome("failure");

        builder.viewNode("success", "/delete/success.xhtml");
        builder.viewNode("failure", "/delete/failure.xhtml");

        builder.returnNode("finished")
                .fromOutcome("airlines");

        return builder.getFlow();
    }
}
