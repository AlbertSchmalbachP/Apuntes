- [Apariciones especificas](#apariciones-especificas)
- [XSD](#xsd)
  - [Inicio XSD](#inicio-xsd)
  - [Minimo y máximo de ocurrencias](#minimo-y-máximo-de-ocurrencias)
  - [Restricciones](#restricciones)
    - [- enumeration](#--enumeration)
    - [- length / minLength / maxLength](#--length--minlength--maxlength)
    - [- pattern](#--pattern)
      - [Teléfono (formato 123-456-7890)](#teléfono-formato-123-456-7890)
      - [Solo letras](#solo-letras)
      - [Nombre (cadena con la primera letra mayúscula)](#nombre-cadena-con-la-primera-letra-mayúscula)
      - [Letras, números y guiones](#letras-números-y-guiones)
      - [5 dígitos (ID, código postal,...)](#5-dígitos-id-código-postal)
      - [Empieza con letra y sigue con números](#empieza-con-letra-y-sigue-con-números)
      - [DNI](#dni)
      - [Email](#email)
    - [- minInclusive / maxInclusive](#--mininclusive--maxinclusive)
    - [- minExclusive / maxExclusive](#--minexclusive--maxexclusive)
    - [- totaldigits / fractiondigits](#--totaldigits--fractiondigits)
    - [- combinación de restricciones](#--combinación-de-restricciones)
- [DTD](#dtd)
  - [Si el DTD es INTERNO](#si-el-dtd-es-interno)
  - [Si el DTD es EXTERNO](#si-el-dtd-es-externo)
# Apariciones especificas
Por defecto, los elementos deben aparecer solo una vez obligatoriamente.
```
+ = one or more, ? = optional, * = zero or more
```
"+" - Si quiero que aparezca más de una vez.
"?" - Si quiero que aparezca una o ninguna vez. Es decir, que sea opcional.
"*" - Si quiero que aparezca ninguna o muchas veces.

# XSD

## Inicio XSD

```
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
```

## Minimo y máximo de ocurrencias
El máximo y el mínimo **número de ocurrencias de un elemento** se determina mediante **minOccurs** y **maxOccurs**. Si no se requiere un límite, se puede poner **"unbounded"**.

```xml
<xs:element name="telefono" type="xs:string" minOccurs="0" maxOccurs="3"/>
```

## Restricciones

Las **restricciones** en XSD se usan para limitar los valores permitidos en los elementos o atributos.  
**Se aplican dentro de un tipo simple (`<xs:simpleType>`)**.

### - enumeration
Define un **conjunto cerrado de valores permitidos**. El valor del elemento o atributo debe ser uno de los definidos.

```xml
<xs:simpleType name="GeneroType">
  <xs:restriction base="xs:string">
    <xs:enumeration value="Masculino"/>
    <xs:enumeration value="Femenino"/>
    <xs:enumeration value="Otro"/>
  </xs:restriction>
</xs:simpleType>
```

### - length / minLength / maxLength
Restringen la **longitud de una cadena**.

```xml
<xs:simpleType name="CodigoPostalType">
  <xs:restriction base="xs:string">
    <xs:length value="5"/>
  </xs:restriction>
</xs:simpleType>

<xs:simpleType name="NombreType">
  <xs:restriction base="xs:string">
    <xs:minLength value="2"/>
    <xs:maxLength value="50"/>
  </xs:restriction>
</xs:simpleType>
```

### - pattern
Restringe con una **expresión regular**.

#### Teléfono (formato 123-456-7890)

```xml
<xs:simpleType name="TelefonoType">
  <xs:restriction base="xs:string">
    <xs:pattern value="\d{3}-\d{3}-\d{4}"/>
  </xs:restriction>
</xs:simpleType>
```

Ejemplo válido: 324-123-9897.

#### Solo letras

```xml
<xs:pattern value="[A-Za-z]+"/>
```

Ejemplo válido: PassWord

#### Nombre (cadena con la primera letra mayúscula)

```xml
<xs:restriction base="xs:string">
  <xs:pattern value="[A-Z][a-z]+"></xs:pattern>
</xs:restriction>
```

#### Letras, números y guiones

```xml
<xs:pattern value="[A-Za-z0-9_-]+"/>
```

Ejemplo válido: usuario_003-s

#### 5 dígitos (ID, código postal,...)

```xml
<xs:pattern value="\d{5}"/>
```

Ejemplo válido: 18009

#### Empieza con letra y sigue con números

```xml
<xs:pattern value="[A-Za-z][0-9]*"/>
```

Ejemplo válido: E123 (y no 123E)

#### DNI

```xml
<xs:element name="dni">
  <xs:simpleType>
    <xs:restriction base="xs:string">
      <xs:pattern value="[0-9]{8}[A-Z]{1}" />
    </xs:restriction>
  </xs:simpleType>
</xs:element>
```
#### Email

```xml
<xs:element name="email">
  <xs:simpleType>
    <xs:restriction base="xs:string">
      <xs:pattern value="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}"/>
    </xs:restriction>
  </xs:simpleType>
</xs:element>
```

### - minInclusive / maxInclusive
Especifican el rango de valores permitidos, **incluyendo los valores límite**.

```xml
<xs:simpleType name="edadPermitida">
  <xs:restriction base="xs:integer">
    <xs:minInclusive value="18"/>
    <xs:maxInclusive value="65"/>
  </xs:restriction>
</xs:simpleType>
```

### - minExclusive / maxExclusive
Especifican el rango de valores permitidos, **excluyendo los valores límite**.

```xml
<xs:simpleType name="rangoAbierto">
  <xs:restriction base="xs:integer">
    <xs:minExclusive value="0"/>
    <xs:maxExclusive value="10"/>
  </xs:restriction>
</xs:simpleType>
```

### - totaldigits / fractiondigits
Controlan la **cantidad de dígitos** totales y decimales.

```xml
<xs:simpleType name="PrecioType">
  <xs:restriction base="xs:decimal">
    <xs:totalDigits value="6"/> <!-- Total de dígitos, incluyendo enteros y decimales -->
    <xs:fractionDigits value="2"/> <!-- Máximo 2 dígitos después del punto decimal -->
  </xs:restriction>
</xs:simpleType>
```

Ejemplo válido: 1234.56 (6 dígitos totales, 2 decimales)

### - combinación de restricciones
**Se pueden combinar varias restricciones**:

```xml
<xs:simpleType name="UsuarioType">
  <xs:restriction base="xs:string">
    <xs:minLength value="5"/>
    <xs:maxLength value="12"/>
    <xs:pattern value="[A-Za-z0-9_]+"/>
  </xs:restriction>
</xs:simpleType>
```

# DTD

## Si el DTD es INTERNO

En el XML:
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE curso [
<!ELEMENT curso (nombre, alumno+)>
<!ELEMENT nombre (#PCDATA)>
<!ELEMENT alumno (nombre, apellido)>
<!ELEMENT apellido (#PCDATA)>
]>
```

## Si el DTD es EXTERNO

En el XML:
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE raiz SYSTEM "ejercicio.dtd">
```

En el DTD:
```xml
<!ELEMENT tienda (nombre, pokemon+)>
<!ELEMENT pokemon (nombre, tipo+, precio)>
<!ELEMENT precio (#PCDATA)>
<!ELEMENT nombre (#PCDATA)>
<!ELEMENT tipo (#PCDATA)>
```