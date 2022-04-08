package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public class Engineer extends Profession {
        private String did;

        public Engineer(String name, String surname, String education, String birthday, String did) {
            super(name, surname, education, birthday);
            this.did = did;

        }
    }

    public class Programmer extends Engineer {
        private int program;

        public Programmer(String name, String surname, String education, String birthday, String did, int program) {
            super(name, surname, education, birthday, did);
            this.program = program;
        }
    }

    public class Builder extends Engineer{
        private int build;

        public Builder(String name, String surname, String education, String birthday, String did, int build) {
            super(name, surname, education, birthday, did);
            this.build = build;
        }
    }

    public class Doctor extends Profession {
        private String quality;

        DiagnosisHeal diagnosisHeal = new DiagnosisHeal("Пациент здоров");
        

        public Doctor(String name, String surname, String education, String birthday, String quality) {
            super(name, surname, education, birthday);
            this.quality = quality;
        }
    }

    public class Surgeon extends Doctor {


        public Surgeon(String name, String surname, String education, String birthday, String quality) {
            super(name, surname, education, birthday, quality);
        }
    }

    public class Dentist extends Doctor {

        public Dentist(String name, String surname, String education, String birthday, String quality) {
            super(name, surname, education, birthday, quality);
        }
    }
}
