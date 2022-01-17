package com.Ontony;

public class Doctor {
    private String name;
    private int experience;
    public Doctor(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String greeting() {
        return String.format(
                "Hello, my name is %s and I have %d experience years\nLet's start, choose organ\n",
                this.name, this.experience);
    }

    public String treating(String choose) {
        Organ organ = new Organ("", "");
        switch (choose.charAt(0)) {
            case '1':
                organ.setName("Skin");
                organ.setMedicalCondition("Just use some ointment");
                if (organ.getTreated()) {
                    return "Doctor treat - " + organ.getName();
                } else {
                    return "He he this is not treatable";
                }
            case '2':
                organ.setName("Eyes");
                organ.setMedicalCondition("Try to move with it, and slowly open it.");
                if (organ.getTreated()) {
                    return "Doctor treat - " + organ.getName();
                } else {
                    return "He he this is not treatable";
                }
            case '3':
                organ.setName("Pisja");
                organ.setMedicalCondition("You will put pisja to someone.");
                if (organ.getTreated()) {
                    return "Doctor treat - " + organ.getName();
                } else {
                    return "He he this is not treatable";
                }
            case '4':
                organ.setName("Foot");
                organ.setMedicalCondition("Ever you try use legs?");
                if (organ.getTreated()) {
                    return "Doctor treat - " + organ.getName();
                } else {
                    return "He he this is not treatable";
                }
            case '5':
                organ.setName("Brain");
                organ.setMedicalCondition("Go home and in there programming a lot.");
                if (organ.getTreated()) {
                    return "Doctor treat - " + organ.getName();
                } else {
                    return "He he this is not treatable";
                }
            case '6':
                System.exit(0);
            default:
                return "Try again choose organ.";
        }
    }

}

