# PVP Custom Damage
A Minecraft spigot plugin that modifies pvp damage.

Either multiply weapon damage or set base damage for all weapons.

## Commands
- Player must be OP
```
/dmg-control [multiply | toggle-base | set-base] [integer | decimal]

EX:
/dmg-control multiply 0             (Sets damage multiplier to 0%; defaults at 0)
/dmg-control toggle-base            (Toggles base damage; defaults off)
/dmg-control set-base               (Sets base damage; defaults at 1.0)
/dmg-control toggle-demo            (Toggles demo mode; Damage all entities; defaults off)
```