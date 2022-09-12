/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int countOfResume = 0;

    void clear() {
        //1-й вариант
        //storage = new Resume[10000];

        //2-й вариант
        for (int i = 0; i < countOfResume; i++) {
            storage[i] = null;
        }
        countOfResume = 0;
    }

    void save(Resume r) {
        storage[countOfResume] = r;
        countOfResume++;
//        for (int i = 0; i < storage.length; i++) {
//            if (storage[i] == null) {
//                storage[i] = r;
//                return;
//            }
//        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < countOfResume; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < countOfResume; i++) {
            if (storage[i].toString().equals(uuid)) {
                for (int j = i; j < countOfResume; j++) {
                    storage[j] = storage[j + 1];
                }
                countOfResume--;
            }
            return;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[size()];
        for (int i = 0; i < countOfResume; i++) {
            allResumes[i] = storage[i];
        }
        return allResumes;
    }

    int size() {
        return countOfResume;
    }
}