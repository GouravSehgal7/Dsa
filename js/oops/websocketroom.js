const RoomStatus = {
    Active: 'Active',
    Inactive: 'Inactive',
  };
  
  const UserStatus = {
    Host: 'Host',
    Other: 'Other',
  };
  
  const UserPower = {
    Admin: 'Admin',
    NonAdmin: 'NonAdmin',
  };
  
  const UserAccessor = {
    ViewOnly: 'ViewOnly',
    AccessAllowed: 'AccessAllowed',
  };

  class Room {
    constructor(id, name, region, maxLimit, entryPassword, hostUserId, hostUserEmail, status = RoomStatus.Active) {
      this.id = id;
      this.name = name;
      this.region = region;
      this.maxLimit = maxLimit;
      this.entryPassword = entryPassword;
      this.hostUserId = hostUserId;
      this.hostUserEmail = hostUserEmail;
      this.status = status;
      this.users = new Map();
      this.currentCount = 0;
    }
}

class User {
    constructor(id, name, email, status = UserStatus.Other, power = UserPower.NonAdmin, accessor = UserAccessor.ViewOnly) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.status = status;
      this.power = power;
      this.accessor = accessor;
    }
}  