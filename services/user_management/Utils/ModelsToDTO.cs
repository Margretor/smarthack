using Main.Entities;
using Main.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Main.Utils
{
    public class ModelsToDTO
    {
        private ModelsToDTO() { }

        public static User UserToDTO(AspNetUsers user, AspNetRoles job)
        {
            return new User
            {
                Id = user.Id,
                Email = user.Email,
                Username = user.UserName,
                Job = job.Name
            };
        }
    }
}