package org.example.collection.builder;

import org.example.cli.UserChannel;
import org.example.cli.UserInputChannel;
import org.example.cli.UserOutputChannel;
import org.example.collection.element.MusicBand;

abstract public class Builder<T> {
    protected T element;
    protected UserInputChannel inputChannel;
    protected UserOutputChannel outputChannel;
    protected boolean userMode;

    public Builder(UserInputChannel inputChannel, T element){
        this.inputChannel = inputChannel;
        this.element = element;
        userMode = false;
    }

    public Builder(UserChannel channel, T element){
        outputChannel = channel;
        inputChannel = channel;
        this.element = element;
        userMode = true;
    }

    abstract T getElement();
}