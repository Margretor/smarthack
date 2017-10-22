using Main.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace Main.Context
{
    public class DatabaseContext : DbContext
    {

        public DatabaseContext() : base("DefaultConnection")
        {
            Database.CreateIfNotExists();
        }

        public DbSet<AspNetUsers> Users { get; set; }
        public DbSet<AspNetRoles> Jobs { get; set; }
        public DbSet<AspNetUserRoles> JobBind { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}