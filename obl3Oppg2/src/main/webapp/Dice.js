class Dice {
    constructor() {
        this.diceValue = 0;

    }

    getDiceValue() {
        return this.diceValue;
    }

    rollDice() {
        return this.diceValue = getRandom();
    }
}

function getRandom() {
    return Math.floor(Math.random() * 6) + 1;

}