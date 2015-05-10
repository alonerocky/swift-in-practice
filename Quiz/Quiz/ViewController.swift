//
//  ViewController.swift
//  Quiz
//
//  Created by shoulong li on 5/9/15.
//  Copyright (c) 2015 shoulong li. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var answerLabe: UILabel!
    
    let questions: [String] = ["From what is cognac made?",
                                "What is 7 + 7?",
                                "What is the capital of Vermont?"
                              ]
    
    let answers: [String] = [
                                "Grapes",
                                "14",
                                "Montpelier"
                            ]
    
    var currentQuestionIndex = 0
    
    @IBAction func showQuestion(sender: AnyObject) {
        ++currentQuestionIndex
        if currentQuestionIndex == questions.count {
            currentQuestionIndex = 0
        }
        
        let question = questions[currentQuestionIndex]
        questionLabel.text = question
        answerLabe.text = "???"
        
        
    }
    
    @IBAction func showAnswer(send: AnyObject) {
        let answer = answers[currentQuestionIndex]
        
        answerLabe.text = answer
    }

}

