package lession16;

/**
 * The Main class to work wiht Reflection
 * @author ARTUR
 * @since JDK 13.0.2
 */
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class newClass = WorkerAtHour.class;

		// String nameClass = newClass.getName();

		System.out.println("Modifirer = " + Modifier.toString(newClass.getModifiers()));
		System.out.println("Simple Name Class= " + newClass.getSimpleName());
		System.out.println("Name class = " + newClass.getName());
		System.out.println("Package name class = " + newClass.getPackage());
		System.out.println("Name Super Class = " + newClass.getSuperclass());
		System.out.println("Interfaces = " + Arrays.toString(newClass.getInterfaces()));

		Constructor<Worker>[] constructors = newClass.getConstructors();
		Constructor<Worker> constructor = constructors[0];

		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println("type paramerer " + i + " = " + class1);
		}
		Constructor<WorkerAtHour> singlrConstructor = newClass.getConstructor(String.class, String.class, int.class,
				float.class, float.class);
		System.out.println(singlrConstructor);

		WorkerAtHour newInstance = singlrConstructor.newInstance("Іванов Іван Іванович", "роботяга", 180, 50.5f, 20f);
		System.out.println(newInstance);
		Field[] fields = newClass.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("Fields " + i + " = " + fields[i]);
		}

		fields = newClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("Fields declared " + i + " = " + fields[i]);
		}

		Field previaField = newClass.getField("premia");
		previaField.set(newInstance, 0);
		System.out.println("\n" + newInstance);

		Method[] methods = newClass.getMethods();
		for (int i = 0; i < 10; i++) {
			Method method = methods[i];
			System.out.println("Metod " + i + " =" + method);
		}

		methods[3].invoke(newInstance, "Петров Петро Петрович");
		System.out.println("New PIB =" + newInstance);

		methods[5].invoke(newInstance, "начальник");
		System.out.println("New posada =" + newInstance);

		float f = (float) methods[0].invoke(newInstance, null);
		System.out.println("Zarplata (premia 0%) = " + f);

		Field premiaField = newClass.getField("premia");
		previaField.set(newInstance, 100);
		f = (float) methods[0].invoke(newInstance, null);
		System.out.println("Zarplata (premia 100%) = " + f);

	}

}
