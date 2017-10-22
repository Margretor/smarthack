using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Tasks.Context;
using Tasks.Models;

namespace Tasks.Repository
{
    public class CommentOperations
    {
        private CommentOperations() { }

        public static void Delete(Comment log)
        {
            using (var ctx = new DatabaseContext())
            {
                ctx.Entry(log).State = System.Data.Entity.EntityState.Deleted;
                ctx.SaveChanges();
            }
        }
    }
}