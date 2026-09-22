- [Documentación Git](#documentación-git)
  - [Introducción](#introducción)
    - [¿Qué es Git?](#qué-es-git)
    - [¿Cómo configurar Git?](#cómo-configurar-git)
    - [Estados ficheros en Git](#estados-ficheros-en-git)
    - [¿Cómo relaciona Git los repositorios?](#cómo-relaciona-git-los-repositorios)
  - [Utilidades](#utilidades)
    - [Recursos web](#recursos-web)
    - [Comandos generales](#comandos-generales)
      - [Git Staging](#git-staging)
      - [Git Commit](#git-commit)
      - [Git Branch](#git-branch)
      - [Git Checkout](#git-checkout)
      - [Git Merge y Git Rebase](#git-merge-y-git-rebase)
      - [Git Cherry-pick](#git-cherry-pick)
      - [Git Stash](#git-stash)
      - [Git Init](#git-init)
      - [Git Clone](#git-clone)
      - [Git Configuration](#git-configuration)
      - [Git Remote](#git-remote)
      - [Git Reset y Git Restore](#git-reset-y-git-restore)
      - [Git Tagging](#git-tagging)
    - [Prácticas frecuentes](#prácticas-frecuentes)

# Documentación Git

## Introducción

### ¿Qué es Git?

**Git** es un **sistema de control de versiones** (**Version Control System** o VCS) que permite a los desarrolladores **gestionar y realizar un seguimiento de los cambios del código a lo largo del tiempo**.

### ¿Cómo configurar Git?

Git **no puede funcionar sin esta configuración**, ya que **necesita asociar cada commit que realices con tu identidad**. Se deberá configurar el **nombre** y el **correo electrónico**. Para configurar estos parámetros, debemos introducir en la terminal:

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tuemail@ejemplo.com"
```

### Estados ficheros en Git

En Git, los ficheros pueden tener 4 estados principales:
* **Untracked** - Archivos nuevos sobre los que el historial de versiones no tiene el conocimiento de la existencia
* **Modified** - Cambios no registrados ni preparados para un commit
* **Staged** - Cambios preparados para el próximo commit
* **Commited** - Cambios que forman ya parte del historial de versiones del projecto

<p align="center">
  <img src="https://reproducibility.rocks/materials/day2/01-git/images/file_cycle2.png" alt="Diagrama de los estados de Git" width="500"/>
  <br>
  <em>Diagrama de los estados de Git</em>
</p>

### ¿Cómo relaciona Git los repositorios?
Así relaciona Git los **repositorios locales y remotos**, mediante **plataformas web** como **GitHub**:
<p align="center">
  <img src="https://www.dougmahugh.com/content/images/2019/01/GitCommands-1.png" alt="Relaciones repositorios Git" width="500"/>
  <br>
  <em>Diagrama relaciones repositorios Git</em>
</p>

## Utilidades

### Recursos web

Una página muy útil para aprender los comandos de Git y otros lenguajes es **w3 schools**. La web incluye tutoriales paso a paso y explicaciones de algunos comandos que ahora veremos. Echale un vistazo pulsando [este enlace](https://www.w3schools.com/git/default.asp).

### Comandos generales

#### Git Staging

* **git add <file>** - Stagear un archivo
* **git add --all** - Stagear TODOS los cambios
* **git status** - Muestra una visión general del estado de los archivos, includído cuáles están commiteados.
* **git restore --staged <file>** - Hacer que un archivo deje de estar staged

#### Git Commit

* **git commit -m "message"** - Hace commit de los cambios, introduciendo un mensaje
* **git log** - Muestra el historial de commits

Para guardar los cambios que hayamos hecho, necesitaremos también un mensaje que describa lo que hemos cambiado.

#### Git Branch

* **git branch <name>** - Crea una nueva rama
* **git branch** - Muestra la lista de todas las ramas
* **git branch -m <oldname> <newname>** - Renombra la rama actual.
* **git branch -d <name>** - Elimina la rama local especificada (si ya está fusionada).

Las ramas te permiten **trabajar en el código por tu cuenta, sin interferir en la rama principal (main)**.

#### Git Checkout

* **git checkout <name>** - Permite desplazarse entre ramas

#### Git Merge y Git Rebase

* **git merge <name>** - Combinar los cambios de una rama en otra
* **git rebase <name>** - Alternativa a git merge para combinar cambios de dos ramas. Al contrario que *git merge*, **git rebase reescribe el historial moviendo los commits de una rama a otra**.

Ten en cuenta: Para hacer un merge o rebase primero necesitamos situarnos en la rama a la que queramos unir la rama separada.

#### Git Cherry-pick

* **git cherry-pick <commit_hash>** - Aplica los cambios introducidos por un commit específico de una rama a tu rama actual.

Nota: Cuando ves la salida de git log, la cadena que aparece al lado de commit es el *commit hash*.

#### Git Stash

* **git stash** - Guarda temporalmente los cambios locales sin commitearlos, permitiéndote cambiar de rama. Luego puedes recuperarlos con **git stash pop**.

#### Git Init

* **git init** - Inicializa un nuevo repositorio Git local.

#### Git Clone

* **git clone <url>** - Clona un repositorio remoto localmente

#### Git Configuration

* **git config --global user.name "tuNombre"** - Establece tu nombre de usuario para los commits.
* **git config --global user.email "tuEmail@STEMgranada.com"** - Establece tu correo electrónico para los commits.

**Sin el --global**, el comando solo tendría efecto para el **repositorio actual**, y no para el usuario.

#### Git Remote

* **git push** - **Sube los commits** de tu rama local al repositorio remoto.
* **git pull** - **Descarga y fusiona los cambios** del repositorio remoto a tu rama local.
* **git fetch** - Descarga los cambios del remoto, pero **NO los fusiona automáticamente** (los deja listos para inspección).

#### Git Reset y Git Restore

* **git reset HEAD~1 (o HEAD^)** - Deshace el último commit
* **git restore <file>** - Descarta los cambios en el directorio de trabajo (archivos no staggeados) de un archivo específico.

#### Git Tagging
* **git tag <tag_name>** - Marca puntos significativos en la historia de un proyecto, como versiones (v2).

### Prácticas frecuentes

* **Comentarios en el código**: Explica en el código por qué se han hecho ciertos cambios, especialmente en secciones complejas o críticas.
* **Realizar commits cortos de forma frecuente**: Los commits grandes, que abarcan múltiples cambios, son más difíciles de revisar y depurar. Es buena prática dividir el trabajo en trozos más pequeños.
* **Revisión de código**: Utiliza las pull requests para solicitar la revisión de tu código.
* **Resolver conflictos con cuidado**
