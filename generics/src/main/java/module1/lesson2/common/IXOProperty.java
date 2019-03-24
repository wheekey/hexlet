package module1.lesson2.common;

public interface IXOProperty {

    Character getSeparatorCharacter();

    static IXOProperty getDefaultProperties() {
        try {
            return FileBasedXOProperty.generateInstance();
        } catch (final IOException e) {
            e.printStackTrace();
            throw new XOCriticalException(e);
        }
    }
}
