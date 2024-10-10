package edu.redwoods.assemble.assemble2;

    /*
    The ProfileDecorator class is part of the Decorator Pattern. This pattern
    allows behavior to be added to individual objects, dynamically, without
    affecting the behavior of other objects from the same class
    */

public abstract class ProfileDecorator implements Profile {
    protected Profile decoratedProfile;

    public ProfileDecorator(Profile decoratedProfile) {
        this.decoratedProfile = decoratedProfile;
    }

    @Override
    public String getDetails() {
        return decoratedProfile.getDetails();
    }
}
