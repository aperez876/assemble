package edu.redwoods.assemble.assemble2;

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
