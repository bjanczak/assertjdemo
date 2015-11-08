package com.github.bjanczak.assertjdemo.data;

/**
 * @author Bartłomiej Jańczak
 */
public class TolkienCharacter {

    private final String name;
    private Integer age;
    private final CharacterType characterType;

    public TolkienCharacter(String name, Integer age, CharacterType characterType) {
        this.name = name;
        this.age = age;
        this.characterType = characterType;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    @Override
    public String toString() {
        return "TolkienCharacter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", characterType=" + characterType +
                '}';
    }
}
