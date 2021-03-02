class Animal {
	private static int diffId = 1;
	private int id;
	private String name;
	private int age;
	private int weight;

	Animal(String name, int age, int weight) {
		this.id = diffId++;
		this.name = name;
		this.setAge(age);
		this.setWeight(weight);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}

class Mammal extends Animal {
	public Mammal(String name, int age, int weight) {
		super(name, age, weight);
	}
}

class Reptile extends Animal {
	public Reptile(String name, int age, int weight) {
		super(name, age, weight);
	}
}

class Bird extends Animal {
	public Bird(String name, int age, int weight) {
		super(name, age, weight);
	}
}

class Lion extends Mammal {
	private final String sound = "Roar";

	public Lion(String name, int age, int weight) {
		super(name, age, weight);
	}

	public String getSound() {
		return sound;
	}
}

class Tiger extends Mammal {
	private final String sound = "Roar";

	public Tiger(String name, int age, int weight) {
		super(name, age, weight);
	}

	public String getSound() {
		return sound;
	}
}

class Crocodile extends Reptile {
	private final String sound = "Croc";

	public Crocodile(String name, int age, int weight) {
		super(name, age, weight);
	}

	public String getSound() {
		return sound;
	}
}

class Peacock extends Bird {
	private final String sound = "Peac";

	public Peacock(String name, int age, int weight) {
		super(name, age, weight);
	}

	public String getSound() {
		return sound;
	}
}
