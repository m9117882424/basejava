/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        //1-й вариант
        //storage = new Resume[10000];

        //2-й вариант
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].toString().equals(uuid)) {
                for (int j = i; j < storage.length - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[9999] = null;
            }
            return;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allNotNull = new Resume[size()];
        for (int i = 0; i < allNotNull.length; i++) {
            allNotNull[i] = storage[i];
        }
        return allNotNull;
    }

    int size() {
        int sizeNotNullStorage = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                sizeNotNullStorage++;
            }
        }
        return sizeNotNullStorage;
    }
}