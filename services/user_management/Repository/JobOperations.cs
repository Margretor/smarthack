using Main.Context;
using Main.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Main.Repository
{
    public class JobOperations
    {
        private JobOperations() { }

        public static AspNetRoles GetJob(string userId)
        {
            using (var ctx = new DatabaseContext())
            {
                var tmp = ctx.JobBind.FirstOrDefault(x => x.UserId == userId);
                return ctx.Jobs.FirstOrDefault(x => x.Id == tmp.RoleId);
            }
        }
    }
}