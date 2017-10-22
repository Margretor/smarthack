using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using Tasks.DTO;
using Tasks.Utils;

namespace Tasks.APICaller
{
    public class UserApi
    {
        private UserApi() { }

        public static User GetUser(string id)
        {
            HttpClient client = new HttpClient();

            string url = Constants.USER_API + "?id=" + id;

            var rs = client.GetAsync(url);
            string json = "";

            System.Threading.Tasks.Task ct = rs.ContinueWith(x => json = Print(x));

            System.Threading.Thread.Sleep(1000);

            return JsonConvert.DeserializeObject<User>(json);
        }

        private static string Print(System.Threading.Tasks.Task<HttpResponseMessage> httpTask)
        {
            System.Threading.Tasks.Task<string> task = httpTask.Result.Content.ReadAsStringAsync();
            string result = "";
            System.Threading.Tasks.Task continuation = task.ContinueWith(t =>
            {
                result = t.Result;
            });
            continuation.Wait();
            return result;
        }
    }
}