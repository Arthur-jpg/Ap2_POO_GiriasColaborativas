# System.arraycopy Explanation

`System.arraycopy` is a static method in Java's System class that efficiently copies elements from one array to another. Let me explain its purpose and usage in the context of the code you selected.

## What System.arraycopy Does

The method is used to copy a section of elements from a source array to a destination array. It's significantly faster than manually copying elements with a loop because:

1. It's a native method implemented at the JVM level
2. It can perform bulk memory operations optimized for the underlying hardware
3. It handles the copying in a single operation

## Syntax and Parameters

The method signature is:

```java
System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

```

Where:

- `src`: Source array to copy from
- `srcPos`: Starting position in the source array
- `dest`: Destination array to copy to
- `destPos`: Starting position in the destination array
- `length`: Number of elements to copy

## In the Selected Code

In your `Giria.java` file, `System.arraycopy` is used in three methods (`adicionarExplicacao`, `adicionarCategoria`, and `adicionarRegiao`) to dynamically expand arrays when adding new elements.

For example, in `adicionarExplicacao`:

```java
System.arraycopy(this.explicacoes, 0, novoArray, 0, tamanhoAtual);

```

This copies all existing explanations from the current array (`this.explicacoes`) to the new, larger array (`novoArray`) before adding the new explanation. This is necessary because arrays in Java have fixed sizes, so to "grow" an array, you need to:

1. Create a new, larger array
2. Copy all existing elements to the new array
3. Add the new element
4. Replace the reference to the old array with the new array

This pattern is common when working with arrays in Java, though in practice, collections like ArrayList are often preferred as they handle this resizing internally.