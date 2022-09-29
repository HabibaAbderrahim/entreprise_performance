package jci.entreprise.performance.entities;

public enum  PostCategory {
    FINANCIERE("Financiere"), ECONOMIQUE("Economique"), ORGANISATIONELLE("Organisationelle"), SOCIALE("Sociale"), SOCIATABLE("Sociable");


    private final String value;

    PostCategory(String value) {
        this.value = value;
    }

    public static PostCategory findByValue(String value) {
        PostCategory result = null;
        for (PostCategory category : values()) {
            if (category.equals(value)) {
                result = category;
                break;
            }
        }
        return result;
    }

}