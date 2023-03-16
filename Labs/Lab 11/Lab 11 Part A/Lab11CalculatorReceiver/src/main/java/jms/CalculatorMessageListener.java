package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorMessageListener {
    private double initialValue=0.0;
 
    @JmsListener(destination = "testCalculatorQueue")
    public void receiveMessage(final String calculatorAsString) {

        String result="";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Calculator calculator = objectMapper.readValue(calculatorAsString, Calculator.class);
            if(calculator.getOperator()=='+')
                initialValue=initialValue+calculator.getValue();
            else if (calculator.getOperator()=='-') {
                initialValue=(initialValue-calculator.getValue());
            } else if (calculator.getOperator()=='*') {
                initialValue=(initialValue*calculator.getValue());
            }
            result="JMS receiver received message: "+calculator.getOperator()+" and "+calculator.getValue()+"  and the result is: "+initialValue;
            System.out.println(result);

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + calculatorAsString+" to a Calculator object");
        }
     }
}

