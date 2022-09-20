# How To: Connect GitHub Packages Maven Repository

1. Create a Personal Access Token on GitHub with the scope `packages:read`
2. Go to your terminal
3. Type `vi ~/.m2/settings.xml` to open in Vim
4. Overwrite the file with the following code:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <activeProfiles>
        <activeProfile>github</activeProfile>
    </activeProfiles>

    <profiles>
        <profile>
            <id>github</id>
            <repositories>
            <repository>
                <id>central</id>
                <url>https://repo1.maven.org/maven2</url>
            </repository>
            <repository>
                <id>github</id>
                <url>https://maven.pkg.github.com/sweat-tek/MavenRepository</url>
                <snapshots>
                <enabled>true</enabled>
                </snapshots>
            </repository>
            </repositories>
        </profile>
    </profiles>

    <servers>
        <server>
            <id>github</id>
            <username>-- GITHUB USERNAME --</username>
            <password>-- GITHUB PERSONAL ACCESS TOKEN --</password>
        </server>
    </servers>
</settings>
```

5. Refresh Maven project