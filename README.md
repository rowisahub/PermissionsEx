# PermissionsEx

PermissionsEx (PEX (not the pipe)) is a full-service permissions plugin giving in-depth control of permissions for a server. PEX is available for various server and proxy platforms:

- [Bukkit/Spigot/Paper](https://dev.bukkit.org/projects/permissionsex) -- [source](permissionsex-bukkit)
- [Sponge](https://ore.spongepowered.org/zml/PermissionsEx) -- [source](permissions-sponge)
<!--- [BungeeCord/Waterfall]
- [Velocity] -->


💬 Having an issue setting up PEX? Check out our [Discord](https://discord.gg/vfxQBBy)

🐞 Found a bug? File a [bug report](/PEXPlugins/PermissionsEx/issues)

⛏ [Development Builds](https://ci.yawk.at/job/PermissionsEx/lastBuild/)


# Development

Want to access permissions in your plugin? PermissionsEx tries to provide extensive compatibility with native APIs, but sometimes more direct access is needed. In that case, PEX has an extensive API that allows querying any sort of information.

PEX can also be extended to support new platforms or implement new data store formats using just the implementation-agnostic `core` API.

## On Maven
PEX is available in a format that can be retrieved in Maven. Its repository:
```xml
<repository>
    <id>pex-repo</id>
    <url>https://repo.glaremasters.me/repository/permissionsex/</url>
</repository>
```

and its dependency specification is:

```xml
<dependency>
    <groupId>ca.stellardrift.permissionsex</groupId>
    <artifactId>permissionsex-core</artifactId> <!-- replace with -sponge or -bukkit depending on which platform you're using -->
    <version>2.0-SNAPSHOT</version>
</dependency>
```

# Contributing

PermissionsEx always appreciates well thought-out pull requests for code changes, documentation improvements, and translations. All contributions must be released under the terms of the Apache 2.0 license.

We build with Maven, which is available on all major platforms. Feel free to run ideas by me in the discord before spending time implementing something that doesn't match my vision for the plugin.




