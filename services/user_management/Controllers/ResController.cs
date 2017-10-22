using Main.Context;
using Main.Entities;
using Main.Models;
using Main.Repository;
using Main.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Main.Controllers
{
    public class ResController : ApiController
    {
        [HttpGet]
        public User GetUser(string id)
        {
            using (var ctx = new DatabaseContext())
            {
                var user = ctx.Users.FirstOrDefault(x => x.Id == id);
                return ModelsToDTO.UserToDTO(user, JobOperations.GetJob(user.Id));
            }
        }
    }
}
