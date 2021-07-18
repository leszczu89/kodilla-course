package com.kodilla.patterns.strategy.predictor;

import com.kodilla.patterns.strategy.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {

    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}
