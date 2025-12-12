package it.nicolachiarappa.context.compatibility.domain.services;

import it.nicolachiarappa.context.catalog.domain.models.Gear;


import it.nicolachiarappa.context.compatibility.domain.models.CompatibilityResult;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashSet;

@Data
@AllArgsConstructor
public class EvaluatorChain<T extends Gear> implements CompatibilityEvaluator<T>{

   LinkedHashSet<EvaluatorNode<T>> nodes;

    @Override
    public CompatibilityResult evaluate(T mainGear, Gear toEvaluate){
        CompatibilityResult result = CompatibilityResult.empty();
        for(EvaluatorNode<T> node: nodes){
            node.doEvaluate(mainGear, toEvaluate, result);
        }
        return result;
    }

    public void addNodeBefore(Class<? extends EvaluatorNode<T>> nodeClass, EvaluatorNode<T> nodeToAdd){
        LinkedHashSet<EvaluatorNode<T>> newNodes = new LinkedHashSet<>();

        if(nodes.isEmpty()){
            nodes.addLast(nodeToAdd);
        }

        for(EvaluatorNode<T> node: nodes){
            if(node.getClass().equals(nodeClass)){
                newNodes.addLast(nodeToAdd);
            }
            newNodes.addLast(node);
        }
        nodes=newNodes;
    }

    public void addNodeAfter(Class<? extends EvaluatorNode<T>> nodeClass, EvaluatorNode<T> nodeToAdd){
        LinkedHashSet<EvaluatorNode<T>> newNodes = new LinkedHashSet<>();

        if(nodes.isEmpty()){
            nodes.addLast(nodeToAdd);
        }

        for(EvaluatorNode<T> node: nodes){
            newNodes.addLast(node);
            if(node.getClass().equals(nodeClass)){
                newNodes.addLast(nodeToAdd);
            }
        }
        nodes=newNodes;
    }

}
