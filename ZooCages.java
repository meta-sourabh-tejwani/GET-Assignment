class Cage {
	private Animal animalInCage[];
	private final int capacity;

	public Cage(int capacity) {
		this.animalInCage = new Animal[capacity];
		this.capacity = capacity;
	}

	public boolean addAnimalInCage(Animal animal) {
		boolean add = false;
		for (int i = 0; i < capacity; i++) {
			if (animalInCage[i] == null) {
				animalInCage[i] = animal;
				add = true;
				break;
			}
		}
		return add;
	}

	public Animal[] getAnimalInCage() {
		return animalInCage;
	}

	public boolean removeAnimalInCage(int id) {
		for (int i = 0; i < capacity; i++) {
			if (animalInCage[i] != null) {
				if (animalInCage[i].getId() == id) {
					animalInCage[i] = null;
					return true;
				}
			}
		}
		return false;
	}
}

class Zone<T> {
	private Cage cages[];
	private int oneCageCapacity;
	private boolean hasCanteen;
	private boolean hasPark;

	public Zone(int cages, int oneCageCapacity, boolean hasCanteen,
			boolean hasPark) {
		this.cages = new Cage[cages];
		this.oneCageCapacity = oneCageCapacity;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}

	public boolean isHasCanteen() {
		return hasCanteen;
	}

	public Cage[] getCages() {
		return cages;
	}

	public boolean isHasPark() {
		return hasPark;
	}

	public boolean addAnimal(T animal) {
		boolean addStatus = false;
		for (int i = 0; i < cages.length; i++) {
			if (cages[i] == null) {
				cages[i] = new Cage(oneCageCapacity);
				addStatus = cages[i].addAnimalInCage((Animal) animal);
				if (addStatus == true)
					break;
			} else {
				addStatus = cages[i].addAnimalInCage((Animal) animal);
				if (addStatus == true)
					break;
			}
		}
		return addStatus;
	}

	public boolean removeAnimal(int id) {
		for (int i = 0; i < cages.length; i++) {
			if (cages[i] != null) {
				if (cages[i].removeAnimalInCage(id) == true) {
					return true;
				}
			}
		}
		return false;
	}

}
