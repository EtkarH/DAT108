class DiceController {

    constructor(root){
        this.root = root;
        this.run = this.run.bind(this);
        this.rollDice = this.rollDice.bind(this);
    }

    rollDice(){
        const dice = new Dice();
        const res = document.getElementById(this.root).querySelector("*[data-diceoutput]");
        res.innerHTML = dice.rollDice();
    }

    run(){
        const btRef = document.getElementById(this.root).querySelector("*[data-dicebutton]");
        btRef.addEventListener("click",this.rollDice,true);
    }
}

"use strict";
const controller = new DiceController("root");
document.addEventListener("DOMContentLoaded",controller.run,true);